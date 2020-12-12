/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kasus;
import java.util.List;


public interface VendingMachine {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin Coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();
}
