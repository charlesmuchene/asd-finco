package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

public class CompanyAccountDialog extends AccountDialog {

    public CompanyAccountDialog(ApplicationForm applicationForm, AccountTypeFunctor accountTypeFunctor) {
        super(applicationForm, "No of employees", accountTypeFunctor);
        setTitle("Add Company Account");
    }

    @Override
    protected void processCustomField(ApplicationForm applicationForm, String value) {
        applicationForm.noOfEmployees = value;
    }
}
