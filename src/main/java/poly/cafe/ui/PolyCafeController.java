/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public interface PolyCafeController {

    void init();

    default void exit() {
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn kết thúc không?", "Xác nhận thoát",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Chương trình sẽ tiếp tục...");
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showChangePasswordDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showSalesJDialog(JFrame frame) {
        this.showJDialog(new SalesJDialog(frame, true));
    }

    default void showHistoryJDialog(JFrame frame) {
        this.showJDialog(new HistoryJDialog(frame, true));
    }

    default void showDrinkManagerJDialog(JFrame frame) {
        this.showJDialog(new DrinkManagerJDialog(frame, true));
    }

    default void showCategoryManagerJDialog(JFrame frame) {
        this.showJDialog(new CategoryManagerJDialog(frame, true));
    }

    default void showCardManagerJDialog(JFrame frame) {
        this.showJDialog(new CardManagerJDialog(frame, true));
    }

    default void showBillManagerJDialog(JFrame frame) {
        this.showJDialog(new BillManagerJDialog(frame, true));
    }

    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new UserManagerJDialog(frame, true));
    }

    default void showRevenueManagerJDialog(JFrame frame) {
        this.showJDialog(new RevenueManagerJDialog(frame, true));
    }
}
