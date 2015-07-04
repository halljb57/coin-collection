package testClasses.enumExample;

import net.downthehall.util.StringValue;

/**
 * Created by joseph on 9/24/2014.
 */
public class TestUserStatus
{
    public TestUserStatus()
    {
        printStatus();
    }

    public static void main(String[] args)
    {
        new TestUserStatus();
    }

    private void printStatus()
    {
        System.out.println(UserStatus.ACTIVE.getStatusCode());
        System.out.println(StringValue.P.getMint());
    }
}
