import org.testng.annotations.Test;


/*
Setup
Login
Look 3 Products
 */
public class TestClass {

    @Test
    public void SetupTextClass(){
    System.out.println("This is setup test");
    }

    @Test
    public void LoginTextClass(){
        System.out.println("This is login test");
    }

    @Test
    public void LookProductTextClass(){
        System.out.println("This is look product test");
    }

    @Test
    public void  TearDown(){
        System.out.println("System closed test");
    }
}
