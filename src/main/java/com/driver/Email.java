package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
// https://acciojob.zoom.us/j/82007439637


    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

//if oldPassword is equal to current password then checks password is valid
        if(oldPassword.equals(this.password)) {

            boolean meetsCriteria = true;

            if(newPassword.length() < 8) {
                meetsCriteria = false;
            }
            else {
                boolean containsUpperCase = false;
                boolean containsLowerCase = false;
                boolean containsDigit = false;
                boolean containsSpecialChar = false;

                for(char ch : newPassword.toCharArray()) {
                    if(Character.isUpperCase(ch)) {
                        containsUpperCase = true;
                    }
                    else if(Character.isLowerCase(ch)) {
                        containsLowerCase = true;
                    }
                    else if(Character.isDigit(ch)) {
                        containsDigit = true;
                    }
                    else if(!Character.isLetterOrDigit(ch)) {
                        containsSpecialChar = true;
                    }
                }

                if(!containsUpperCase || !containsLowerCase || !containsDigit || !containsSpecialChar)  {
                    meetsCriteria = false;
                }
            }
        
            if(meetsCriteria) {
                this.password = newPassword;
            }
        }
    }
}