package uitests;

import Utils.ExcelDataProvider;

import java.util.Collections;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        String class_name = "TbLogin";
        String method_name = "jd_login";

        ExcelDataProvider excel_driver = new ExcelDataProvider(class_name, method_name);

        String ErrorUser = "";
        String ErrorPwd = "";
        String RightUser = "";
        String RightPwd = "";
        String RUser = "";
        while(excel_driver.hasNext() == true)
        {
            Object[] info_list = excel_driver.next();
            List<String> newinfo_list = Collections.singletonList(String.valueOf(info_list));
            int info_size = newinfo_list.size();
            for(int i=0; i<info_size; i++){
                ErrorUser = newinfo_list.get(0);
                ErrorPwd = newinfo_list.get(1);
                RightUser = newinfo_list.get(2);
                RightPwd = newinfo_list.get(3);
                RUser = newinfo_list.get(4);
            }
            System.out.println(ErrorUser +" "+ ErrorPwd +" "+ RightUser +" "+ RightPwd +" "+ RUser);
        }
    }
}

