package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            while (select < 0 || select > 6) {
                System.out.println("!!!! Error! Incorrect menu item selected! !!!!");
                select = input.askInt("Select: ");
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }

    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllItems(),
                new ReplaceAction(),
                new DeleteAction(),
                new SearchByID(),
                new SearchByName(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
