package com.check.sales.view;

import com.check.sales.dto.InventoryItemDto;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Collection;

public class AutocompleteJComboBox extends JComboBox<InventoryItemDto> {

    private final Searchable<InventoryItemDto, String> optionsSource;

    // TODO implement not copying when an option is selected, instead copy only when Enter pressed
    public AutocompleteJComboBox(Searchable<InventoryItemDto, String> optionsSource) {
        super();
        this.optionsSource = optionsSource;
        initialize();
    }

    private void initialize() {
        this.setEditable(true);

        final Component comboboxEditor = this.getEditor().getEditorComponent();
        if (comboboxEditor instanceof JTextComponent) {
            final JTextComponent comboboxInput = (JTextComponent) comboboxEditor;
            this.initializeAutocompletion(comboboxInput, this);
            this.initializeFocusHandling(comboboxInput, this);
        } else {
            throw new IllegalStateException("Editing component is not a JTextComponent!");
        }
    }

    private void initializeAutocompletion(JTextComponent comboboxInput, AutocompleteJComboBox self) {
        comboboxInput.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                update();
            }

            public void update() {
                SwingUtilities.invokeLater(() -> {
                    Collection<InventoryItemDto> suitableOptions =
                            self.optionsSource.search(comboboxInput.getText());
                    self.setEditable(false);
                    self.removeAllItems();
                    suitableOptions.forEach(self::addItem);
                    self.setPopupVisible(true);
                    self.setEditable(true);
                    comboboxInput.requestFocus();
                });
            }
        });
    }

    private void initializeFocusHandling(JTextComponent comboboxInput, AutocompleteJComboBox self) {
        comboboxInput.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                if (comboboxInput.getText().length() > 0) {
                    self.setPopupVisible(true);
                }
            }

            @Override
            public void focusLost(FocusEvent arg0) {
            }
        });
    }
}
