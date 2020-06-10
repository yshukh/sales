package com.check.sales.view;

import com.check.sales.dto.InventoryItemDto;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteJComboBox extends JComboBox {
    static final long serialVersionUID = 4321421L;
    private final Searchable<InventoryItemDto, String> searchable;

    public AutocompleteJComboBox(Searchable<InventoryItemDto, String> s) {
        super();
        this.searchable = s;
        setEditable(true);
        Component c = getEditor().getEditorComponent();

        if (c instanceof JTextComponent) {
            final JTextComponent tc = (JTextComponent) c;
            tc.getDocument().addDocumentListener(new DocumentListener() {

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
                        List<InventoryItemDto> founds = new ArrayList<>(searchable.search(tc.getText()));
                        Set<InventoryItemDto> foundSet = new HashSet<>();
                        for (InventoryItemDto s1 : founds) {
                            foundSet.add(s1);
                        }
//                        TODO InventoryItemDto should implement Sortable
//                        founds = founds.stream().sorted().collect(Collectors.toList());
                        setEditable(false);
                        removeAllItems();
                        //if founds contains the search text, then only add once.

                        if (!foundSet.contains(tc.getText().toLowerCase())) {
                            addItem(tc.getText());
                        }

                        for (InventoryItemDto s1 : founds) {
                            addItem(s1);
                        }
                        setPopupVisible(true);
                        setEditable(true);
                        tc.requestFocus();
                    });
                }
            });

            tc.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent arg0) {
                    if (tc.getText().length() > 0) {
                        setPopupVisible(true);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                }
            });
        } else {
            throw new IllegalStateException("Editing component is not a JTextComponent!");
        }
    }
}
