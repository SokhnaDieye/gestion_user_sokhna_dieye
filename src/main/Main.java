package main;

import dao.*;
import entity.User;
import entity.Role;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IUser userDao=new UserImpl();
        IRole roleDao=new RoleImpl();
        Scanner sc=new Scanner(System.in);
        int choix;
        Role r=new Role();

        /* Ajout Role
        System.out.println("Donner le nom de votre role: ");
        String NameRole=sc.nextLine();
        r.setName(NameRole);
        int ok=roleDao.add(r);
        if (ok==1){
            System.out.println("Role enregistrer avec succes");
        }else {
            System.out.println("Echec");
        }
        System.out.println("Liste des roles");
        for (Role rl : roleDao.list()) {
            System.out.println("ID = " + rl.getId());
            System.out.println("Name = " +rl.getName().toUpperCase());
        }*/

        /*Creer un utulisateur  */
        User u=new User();
        System.out.println("Donner votre email: ");
        u.setEmail(sc.nextLine());
        System.out.println("Donner votre mot de passe: ");
        String mdp=sc.nextLine();
        u.setPassword(mdp);
        u.setPassword_hashed(mdpHasher(mdp));
        System.out.println("Liste role: ");
        for (int i=0;i<roleDao.list().size();i++){
            System.out.println((i+1)+ ". "+roleDao.list().get(i).getName());
        }
        do{
            System.out.println("Choissisez un role");
             choix=sc.nextInt();
        }while (choix < 1 && choix > roleDao.list().size());
        u.setRole(roleDao.get(choix));
        int ok1=userDao.add(u);
        if(ok1 == 1)
            System.out.println("User enregistre avec succés !");
        else
            System.out.println("Echec !");


       ///////////////////Liste Utulisateur//////////////////////
        System.out.println("Liste Utilisateur");
        for (User user:userDao.list()){
            System.out.println("ID: "+user.getId());
            System.out.println("Email: "+user.getEmail());
            System.out.println("Password: "+user.getPassword());
            System.out.println("Password_hasher: "+user.getPassword_hashed());
            System.out.println("Role: "+user.getRole().getName());
        }
    }


    //Algorithme qui permet de hasher un mot de passe
    public static String mdpHasher(String mdp) {
        int cpt = 0;
        for (int i = 0; i < mdp.length(); i++) {
            cpt +=mdp.charAt(i);
        }
        return Integer.toString(cpt);
    }

}