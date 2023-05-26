package fr.jasmin.model.dao.interfaces;

import java.util.List;

import fr.jasmin.entity.Item;

public interface IItemDao {
	// Ajoute un nouvel item
    void addItem(Item item);
    
    // Récupère un item par son identifiant
    Item getItemById(int id);
    
    // Met à jour les informations d'un item existant
    void updateItem(Item item);
    
    // Supprime un item
    void deleteItem(Item item);
    
    // Récupère tous les items
    List<Item> getAllItems();
}
