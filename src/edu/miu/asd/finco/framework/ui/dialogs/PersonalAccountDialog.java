package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

public class PersonalAccountDialog extends AccountDialog {
    public PersonalAccountDialog(ApplicationForm applicationForm) {
        super(applicationForm, "Date of Birth");
        setTitle("Add Personal Account");
    }

    @Override
    protected void processCustomField(ApplicationForm applicationForm, String value) {
        applicationForm.dateOfBirth = value;
    }
}
