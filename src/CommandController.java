public interface CommandController {
    public void execute(char command);
    public boolean canHandle(char command);
}
