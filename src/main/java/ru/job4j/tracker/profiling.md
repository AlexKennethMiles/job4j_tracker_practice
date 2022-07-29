## Улититы jps, jmap, jstat
* ####jps + jmap

Вывод `jmap -histo <pid>` до заполнения памяти заявками:
![jmap1](https://i2.paste.pics/HUTWT.png)

После:

![jmap2](https://i2.paste.pics/HUTWU.png)

Из скриншотов видно, что значительно увеличилось число экземпляров (*instances*) таких классов как `java.lang.String`,
`java.lang.LocalDateTime`, `java.lang.LocalDate`, `java.lang.LocalTime`, `java.lang.Object`, что обусловлено наличием
этих полей в экземплярах класса `ru.job4j.tracker.Item`.

Операции в консольном приложении между вызовами утилит:
![jmap_console](https://i2.paste.pics/HUTWV.png)

* ####jps + jstat

Утилита вызвалась в начале работы приложения,
затем были созданы 250000 экземпляров Item,
после чего была начата операция удаления и, следовательно,
очищения памяти.

![jstac_console](https://i2.paste.pics/HUTWX.png)

Видно, как значение в столбце YGC (*Number of young generation GC Events*) начинает возрастать (0->112).

![jstat](https://i2.paste.pics/HUTWW.png)

* ####jconsole
Порядок действий:
1. Создание 250000 экземпляров `ru.job4j.tracker.Item`
2. Вывод всех экземпляров в консоль
3. Удаление последнего экземпляра (с id==250000) и создание нового на его месте
4. Вывод обновлённого списка экземпляров в консоль
5. Удаление всех 250000 экземпляров
6. Вывод (пустого) списка хранимых item'ов

![jconsole](https://i2.paste.pics/HUTWY.png)
Скачок потребляемой памяти на 1 обусловлено инициализацией объектов.
На этапе 2 резкий подъём и спад вызван созданием копии исходного массива, а также
созданием временных сущностей item'ов для вывода через цикл for-each.

Метод *findAll()* класса `ru.job4j.tracker.MemTracker`:
![findAll](https://i2.paste.pics/HUWBV.png)
Метод *execute()* класса `ru.job4j.tracker.ShowAllItems`:

![execute](https://i2.paste.pics/HUWF8.png)

Операции на 3 этапе не оказывают значительного влияние на работу с памятью.

На 4 этапе отработанная память остаётся занятой большее время, чем на этапе 2.
Вероятно, это вызвано тем, что из-за манипуляций на 3 этапе, буфферные объекты использовались дольше,
чем на 2 этапе и потому они успели перейти в поколение уровня выше и *Garbage Collector*
очистил их на этапе более глубокой сборки.

На этапе 5 солидные траты памяти вызваны несколькими слоями проверки индекса списка.

Метод *delete()* класса `ru.job4j.tracker.MemTracker`:
![](https://i2.paste.pics/HUWPI.png)

Метод *indesOf()* класса `ru.job4j.tracker.MemTracker`:
![](https://i2.paste.pics/HUWPP.png)

* ####Ситуация переполнения heap'а

Детали ввода консоли:
![out_console](https://i2.paste.pics/HV3J9.png)

Графики jconsole:
![jconsole](https://i2.paste.pics/HV3IP.png)

Прослеживается взрывной период потребления ресурсов:
рост с +-15 МБ сменился на рост в +4 ГБ. 

Ошибка `java.lang.OutOfMemoryError: Java heap space` вызвана тем, что *Garbage Collector*
не успел запустить процесс сборки — слишком быстрое и большое потребление памяти.