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
import java.util.List;
import java.util.stream.Collectors;

public class AutocompleteJComboBox extends JComboBox<InventoryItemDto> {

    private final Searchable<InventoryItemDto, String> dropdownOptionsSource;

    // TODO handle when option selection has been confirmed via Enter (and think about another ways of selecting)

    // TODO allow navigate through whole dropdown list without comboboxInput changing
    //  (now it works as next: when user navigates through dropdown the comboboxInput changes immediately according to
    //  value which is selected and dropdown gets reloaded by list containing only one value)

    // TODO implement ignore case for inventory item name searching within comboboxInput

    // TODO add barcode supporting and think how to handle both inventory item names and barcodes in combobox
    //  (first idea to check: if comboboxInput contains only numbers, then it is barcode; else inventory item.
    //  Consequently, inventory item name should contain at least one letter or non-number character)
    public AutocompleteJComboBox(Searchable<InventoryItemDto, String> optionsSource) {
        super();
        this.dropdownOptionsSource = optionsSource;
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

            private void update() {
                SwingUtilities.invokeLater(() -> {
                    final Collection<InventoryItemDto> suitableOptions =
                            self.dropdownOptionsSource.search(comboboxInput.getText());
                    self.setEditable(false);
                    self.removeAllItems();
                    handleCurrentInput(suitableOptions);
                    suitableOptions.forEach(self::addItem);
                    self.setPopupVisible(true);
                    self.setEditable(true);
                    comboboxInput.requestFocus();
                });
            }

            private void handleCurrentInput(final Collection<InventoryItemDto> suitableOptions) {
                List<String> dropdownTerms = suitableOptions.stream()
                        .map(InventoryItemDto::getName)
                        .collect(Collectors.toList());
                // add only if input isn't present in dropdown
                if (!dropdownTerms.contains(comboboxInput.getText())) {
                    self.addItem(new InventoryItemDto(-1, comboboxInput.getText()));
                }
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
