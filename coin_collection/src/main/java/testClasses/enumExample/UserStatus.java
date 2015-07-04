package testClasses.enumExample;

/**
 * Created by joseph on 9/24/2014.
 *
 * Code Location - http://www.mkyong.com/java/java-enum-example/
 */
public enum UserStatus
{
    PENDING("P"), ACTIVE("A"), INACTIVE("I"), DELETED("D"), D("Denver");

    private String statusCode;

    private UserStatus(String s)
    {
        statusCode = s;
    }

    public String getStatusCode()
    {
        return statusCode;
    }
}
