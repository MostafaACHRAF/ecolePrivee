package GUI;

import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Mostafa ACHRAF on 12/23/2016.
 */
public class EditingCell extends TableCell<GestionNotes_ElevesNotes, String> {
    private TextField textField;
    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.requestFocus();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                    EditingCell.this.getTableView().requestFocus();//why does it lose focus??
                    EditingCell.this.getTableView().getSelectionModel().selectBelowCell();
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        });

        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode().isDigitKey()) {
                    if (CellField.isLessOrEqualOneSym()) {
                        CellField.addSymbol(t.getText());
                    } else {
                        CellField.setText(textField.getText());
                    }
                    textField.setText(CellField.getText());
                    textField.deselect();
                    textField.end();
                    textField.positionCaret(textField.getLength() + 2);//works sometimes

                }
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem();
    }
}
