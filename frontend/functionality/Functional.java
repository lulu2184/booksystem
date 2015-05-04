package frontend.functionality;

import frontend.PageController;

/**
 * Created by LU on 15/5/4.
 */
abstract class Functional {

    public Functional(){

    }

    protected abstract void getInfo();
    protected abstract void execute(PageController pc);

    public void Do(PageController pc){
        getInfo();
        execute(pc);
    }

}
