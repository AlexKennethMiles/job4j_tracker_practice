package ru.job4j.tracker;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            while (select < 0 || select > actions.length) {
//                System.out.println("!!!! Error! Incorrect menu item selected! !!!!");
                select = input.askInt("Select: ");
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }

    }

    private void showMenu(UserAction[] actions) {
        output.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            output.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllItems(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new SearchByID(output),
                new SearchByName(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
