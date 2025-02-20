package testData;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "invalidLoginData")
    public Object[][] provideInvalidLoginData() {
        return new Object[][]{
                {"", "", GlobalData.usernameRequiredError},
                {"user", "", GlobalData.passwordRequiredError},
                {"user", GlobalData.password, GlobalData.invalidDataError},
                {GlobalData.validUser, "password", GlobalData.invalidDataError},
                {GlobalData.lockedUser, GlobalData.password, GlobalData.lockedUserError},
        };
    }

    @DataProvider(name = "invalidShippingData")
    public Object[][] provideInvalidShippingData() {
        return new Object[][]{
                {"", "", "", GlobalData.firstNameRequiredError},
                {"Test", "", "", GlobalData.lastNameRequiredError},
                {"Test", "Test", "", GlobalData.postalCodeRequiredError},
        };
    }


}
