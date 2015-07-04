package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/15/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCoin
{
    private static TestCoin ourInstance = new TestCoin();

    private TestCoin()
    {
    }

    public static TestCoin getInstance()
    {
        return ourInstance;
    }
}
