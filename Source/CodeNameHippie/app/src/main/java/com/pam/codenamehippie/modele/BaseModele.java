package com.pam.codenamehippie.modele;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Créé par Carl St-Louis le 23-11-2015.
 */
public abstract class BaseModele {

    @SerializedName("id")
    private int id;
    private BaseModeleDepot depot;
    protected Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create();

    // Accesseur
    public int getId() {
        return id;
    }

    public BaseModeleDepot getDepot() {
        return depot;
    }

    // Constructeur
    public BaseModele(BaseModeleDepot depot, int id){
        this.id = id;
        this.depot = depot;
    }

    /**
     * Méthode de sérialisation du modèle en JSON.
     *
     * @return le modèle en format JSON.
     */
    public String toJSon(){
        return this.gson.toJson(this);
    }

    /**
     * Méthode de désérialisation du modèle en JSON
     *
     * @param json
     * @return une instance du modèle.
     */
    public BaseModele fromJSon(String json){
        return  gson.fromJson(json,BaseModele.class);
    }

    /**
     *  Surcharge de la méthode {@link Object#toString()} appelle la méthode {@link BaseModele#toJSon()}.
     *
     * @return l'objet en format JSON.
     * @see BaseModele#toJSon()
     */
    @Override
    public String toString() {
        return this.toJSon();
    }
}
