package frontend;

import backend.User.User;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by LU on 15/5/3.
 */
public class PageController {
    private Page currentPage = Page.MAINMENU;
    private Stack<Page> page_stack;
    private User user = null;

    public PageController(){
        page_stack = new Stack<Page>();
    }

    public void changeCurrentPage(Page nextpage){
        page_stack.push(currentPage);
        currentPage = nextpage;
    }

    public boolean exitCurrentPage() throws EmptyStackException{
        if (page_stack.empty()) return false;
        currentPage = page_stack.pop();
        return true;
    }

    public void setUser(User _user){
        user = _user;
    }

    public String getUserName(){
        return user.getUsername();
    }

    public User getUser(){
        return user;
    }

    public void Do(){
        while(currentPage.Do(this));
    }
}
