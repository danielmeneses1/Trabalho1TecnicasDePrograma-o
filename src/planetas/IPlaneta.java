package planetas;

public interface IPlaneta{
    public void mover(int momento);
    public default void totalRotacao(int momento){};
    public default void totalAnos(){}

}
