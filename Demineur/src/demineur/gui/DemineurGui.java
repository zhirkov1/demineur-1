/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demineur.gui;

import demineur.Demineur;
import demineur.Partie;
import demineur.tools.MyException;

/**
 *
 * @author alexis
 */
public class DemineurGui extends Demineur {
    DemineurGuiVue _vue;

    public DemineurGui(){
        super();
        _vue = new DemineurGuiVue(this, _grille,_partie);
    }

    public void nouvellePartie() {
        super.initialiser();
        _vue.dispose();
        _partie = new Partie(this);
        _vue = new DemineurGuiVue(this,_grille,_partie);
    }

    public void nouvellePartie(int difficulte) throws MyException{
        _grille = setupGrille(difficulte);
        nouvellePartie();
        /*
        super.initialiser();
        _vue.dispose();
         _partie = new Partie(this);
        _vue = new DemineurGuiVue(this,_grille,_partie);
                                           *
                                           */
    }

    public void nouvellePartie(int lignes,int colonnes,int mines)throws MyException{
        _grille = setupGrille(lignes,colonnes,mines);
        nouvellePartie();
        /*
        super.initialiser();
        _vue.dispose();
         _partie = new Partie(this);
        _vue = new DemineurGuiVue(this,_grille,_partie);
         *
         */
    }

    public void decouvreCase(int x, int y) {
        _grille.decouvrirCase(x, y);
        _vue.get_grilleVue().decouvrirCase(x, y);
    }

    public void majDrapeau(int x, int y) {
        _grille.majDrapeau(x, y);
        _vue.get_grilleVue().poserDrapeau(x, y);
    }

    public void perdu(){
        _grille.partiePerdue();
        _vue.get_grilleVue().partiePerdue();
    }

    public static void main(String args[]){
        DemineurGui d = new DemineurGui();
    }
}
