package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker fake = new Faker();
	
	public String randomUserName()
	{
		return fake.name().username();
	}
	
	public String randomUserPassword()
	{
		return fake.internet().password();
	}
	
	public String randomFullName()
	{
		return fake.name().fullName();
	}
	
	public String randomEmailUser()
	{
		return fake.internet().emailAddress();
	}

}
