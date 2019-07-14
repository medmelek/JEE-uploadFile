package com.melek.serveltes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/MyServelet")
public class MyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final int TAILLE_TAMPON = 10240;
	    public static final String CHEMIN_FICHIERS = "C:\\test\\"; // A changer
    
       
    public MyServelet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getSession().invalidate();
		request.setAttribute("temp", "35");
		if (request.getSession().getAttribute("name")!=null) {
			if (request.getSession().getAttribute("name").equals("melek"))
			this.getServletContext().getRequestDispatcher("/WEB-INF/file3.jsp").forward(request, response);
			
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/file.jsp").forward(request, response);
		}

	}

	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		/* String description = request.getParameter("description");
	        request.setAttribute("description", description );
	         
	        Part part = request.getPart("fichier");
	            
	        String nomFichier = getNomFichier(part);

	        if (nomFichier != null && !nomFichier.isEmpty()) {
	            String nomChamp = part.getName();
	            
	             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
	                    .substring(nomFichier.lastIndexOf('\\') + 1);

	            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

	            request.setAttribute(nomChamp, nomFichier);
	        }*/
	       	 
		 String name = request.getParameter("name");
		 String pseudo = request.getParameter("pseudo");

		 	 	
		 		if ((name.equals("melek")) &&  (pseudo.equals("medmelek"))) {
		 		
		 			HttpSession session = request.getSession();
		 			session.setAttribute("name", name);
		 			session.setAttribute("pseudo",pseudo);
			        this.getServletContext().getRequestDispatcher("/WEB-INF/file3.jsp").forward(request, response);

		 		}else {
		 			
		 			request.setAttribute("outh",false);
			        this.getServletContext().getRequestDispatcher("/WEB-INF/file.jsp").forward(request, response);

		 		}
		 


	    }

	    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	    
	    private static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return null;
	    }   
	}
