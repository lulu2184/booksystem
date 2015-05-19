package frontend;

import backend.update.DeclareUser;
import frontend.functionality.*;
import frontend.menu.MainMenu;
import frontend.menu.ManageMenu;
import frontend.menu.OrderMenu;
import frontend.menu.UserMenu;

import javax.print.attribute.standard.Copies;
import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
public enum Page {
    MAINMENU("Book Store Manage System") {
        boolean Do(PageController pc) throws EmptyStackException {
            return MainMenu.getInstance().display(pc);
        }
    },
    USERMENU("Book Store Manage System ---- User Page") {
        boolean Do(PageController pc) {
            UserMenu.getInstance().display(pc);
            return true;
        }
    },
    MANAGERMENU("enter manager menu") {
        boolean Do(PageController pc) {
            return ManageMenu.getInstance().display(pc);
        }
    },
    LOGIN("login") {
        boolean Do(PageController pc) {
            return interactiveActions(new Login(), pc);
        }
    },
    REGISTER("register") {
        boolean Do(PageController pc) {
            return interactiveActions(new Register(), pc);
        }
    },
    ORDERMENU("start an order.") {
        boolean Do(PageController pc) {
            return OrderMenu.getInstance().display(pc);
        }
    },
    INSERT_IN_ORDER("add books into current order.") {
        boolean Do(PageController pc) {
            return interactiveActions(new InsertInOrder(), pc);
        }
    },
    CREATE_NEW_BOOK("insert a new book.") {
        boolean Do(PageController pc) {
            return interactiveActions(new InsertBook(), pc);
        }
    },
    NEW_COPIES_ARRIVAL("arrival of more book copies.") {
        boolean Do(PageController pc) {
            return interactiveActions(new CopiesArrival(), pc);
        }
    },
    GIVE_FEEDBACK("give feedback to a book.") {
        boolean Do(PageController pc) {
            return interactiveActions(new GiveFeedback(), pc);
        }
    },
    RATE_FOR_FEEDBACK("rate for a feedback.") {
        boolean Do(PageController pc) {
            return interactiveActions(new Rate(), pc);
        }
    },
    DECLARE_USER("give trust number to a user.") {
        boolean Do(PageController pc) {
            return interactiveActions(new GiveTrustNumber(), pc);
        }
    },
    USEFUL_FEEDBACK("find the most n useful feedback for a book.") {
        boolean Do(PageController pc) {
            return interactiveActions(new FindUsefulFeedback(), pc);
        }
    },
    BUYING_SUGGESTION("") {
        boolean Do(PageController pc) {
            return interactiveActions(new BuyingSuggestion(), pc);
        }
    },
    ORDER_SUMMARY("") {
        boolean Do(PageController pc) {
            return interactiveActions(new OrderSummary(), pc);
        }
    },
    AUTHOR_DEGREE("calculate degree of two authors.") {
        boolean Do(PageController pc) {
            return interactiveActions(new DegreeOfAuthor(), pc);
        }
    },
    POP_BOOK_IN_SEMESTER("get the 10 most popular books in a semester.") {
        boolean Do(PageController pc) {
            return interactiveActions(new PopBook(), pc);
        }
    },
    POP_AUTHOR_IN_SEMESTER("get the 10 most popular authors in a semester.") {
        boolean Do(PageController pc) {
            return interactiveActions(new PopAuthor(), pc);
        }
    },
    POP_PUBLISHER_IN_SEMESTER("get the 10 most popular publishers in a semester.") {
        boolean Do(PageController pc) {
            return interactiveActions(new PopPublisher(), pc);
        }
    },
    TRUSTER_USER("get the m most trusted users.") {
        boolean Do(PageController pc) {
            return interactiveActions(new TrustedUser(), pc);
        }
    },
    USEFUL_USER("get the m most useful users.") {
        boolean Do(PageController pc) {
            return interactiveActions(new GetUsefulUser(), pc);
        }
    },
    BOOK_BROWSING("book browsing.") {
        boolean Do(PageController pc) {
            new BookBrowsing().Do(pc);
            return true;
        }
    };

    private final String message;

    Page(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    protected void displayTitile() {
        System.out.println("             Database book manage system");
    }

    abstract boolean Do(PageController pc);

    protected boolean interactiveActions(InterativeForm iform, PageController pc) {
        try {
            iform.Do(pc);
        } catch (NoSuchFieldException e) {
            System.err.println("No Such Field " + e.getMessage());
            pc.exitCurrentPage();
        }
        return true;
    }

}
