package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

public class EditUserView implements View {
    private Controller controller;
    UserService service = new UserServiceImpl();
    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

//    @Override
//    public void fireEventShowDeletedUsers() {
//        controller.onShowAllDeletedUsers();
//    }

    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }
    public void fireEventUserChanged(String name, long id, int level){
        controller.onUserChange(name, id,level);
    }

}
