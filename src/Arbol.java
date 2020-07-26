
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Arbol
{
        private Nodo raiz;

        public Arbol() {
           raiz = null;
        }
        public Nodo getRaiz(){
            return raiz;
        }
        public boolean esPrimo(int n){
            if(n<=1)
                return false;
            for(int i = 2; i < n;i++){
                if(n%i == 0)
                    return false;
            }
            return true;
        }
        private boolean esHoja(Nodo pr) {
            return pr.getHI() == null && pr.getHD() == null;
        }     

        public void insertar(int x)
        {
            Nodo q = new Nodo(x);
            if (raiz == null){
                raiz = q;
                return;
            }
            Nodo pr=raiz; 
            Nodo ant=null;
            while (pr != null){
                ant=pr;
                if (x < pr.getElem())
                    pr = pr.getHI();
                else
                    if (x > pr.getElem())
                       pr = pr.getHD();
                    else
                        return ;
            }
            if (x < ant.getElem())
                ant.setHI(q);
            else
                ant.setHD(q);
        }
        
            
    
        private void preOrden(Nodo pr,JTextArea rt)
        {
            if (pr != null) {
                rt.append( String.valueOf(pr.getElem() + "  ") );
                preOrden(pr.getHI(),rt);
                preOrden(pr.getHD(),rt);
            }
        }

        public void preOrden(JTextArea rt) {
            preOrden(raiz,rt);
        }

        private void InOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)  {
                InOrden(pr.getHI(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
                InOrden(pr.getHD(),rt);
            }
        }

        public void InOrden(JTextArea rt)
        {
            InOrden(raiz,rt);
        }

        private void PostOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)
            {
                PostOrden(pr.getHI(),rt);
                PostOrden(pr.getHD(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
            }
        }

        public void PostOrden(JTextArea rt)
        {
           PostOrden(raiz,rt);
        }

        private int suma(Nodo pr)
        {
            if (pr == null)
                return 0;
            else
                if (esHoja(pr))  // no es necesario
                    return pr.getElem();
                else
                {
                    int hi = suma(pr.getHI());
                    int hd = suma(pr.getHD());

                    return hi + hd + pr.getElem();
                }
        }

        public int suma() {
            return suma(raiz);
        }
        
        
        private int multiplicar(Nodo pr){
            
            if(pr == null){
                return 1;
            }
            int hi = multiplicar(pr.getHI());
            int hd = multiplicar(pr.getHD());
            
            return hi * hd * pr.getElem();
        }
        public int multiplicar(){
            return multiplicar(raiz);
        }
   
        private int sumarPares(Nodo pr)
        {
            if (pr == null)
                return 0;
             else
                if (esHoja(pr))  // no es necesario
                    if(pr.getElem()%2 == 0)
                        return pr.getElem();
                    else
                        return 0;
            int hi = sumarPares(pr.getHI());
            int hd = sumarPares(pr.getHD());
            if(pr.getElem() %2 == 0)
                return hi + hd + pr.getElem();
            else
                return hi + hd;
        }
        public int sumarPares() {
            return sumarPares(raiz);
        }
    private int cantidadElem(Nodo pr){   
            if(pr == null){
                return 0;
            }
             else
                if (esHoja(pr))  // no es necesario
                    return 1;
            int hi = cantidadElem(pr.getHI());
            int hd = cantidadElem(pr.getHD());
            
            return hi + hd + 1;
        }
    public int cantidadElem(){
        return cantidadElem(raiz);
    }
    private int mayor(Nodo pr){   
            if(pr.getHD() == null){
                return pr.getElem();
            }
             else
                if (esHoja(pr))  // no es necesario
                    return pr.getElem();
            int hd = mayor(pr.getHD());
            return hd;
        }
    public int mayor(){
        return mayor(raiz);
    }
        
    private int menor(Nodo pr){   
            if(pr.getHI() == null){
                return pr.getElem();
            }
             else
                if (esHoja(pr))  // no es necesario
                    return pr.getElem();
            int hi = menor(pr.getHI());
            return hi;
        }
    public int menor(){
        return menor(raiz);
    }
    
    private int sumaNivel(Nodo pr, int nivel){
        if(pr == null){
            return 0;
        }
        int hi = sumaNivel(pr.getHI(), nivel-1);
        int hd = sumaNivel(pr.getHD(), nivel-1);
        if(nivel ==0)
            return hi + hd + pr.getElem();
        return hi + hd;
    }
    public int sumaNivel(int nivel){
        return sumaNivel(raiz,nivel);
    }
    private int cantidadElemPar(Nodo pr){   
            if(pr == null){
                return 0;
            }
             else
                if (esHoja(pr))  // no es necesario
                    if(pr.getElem()%2 == 0)
                        return 1;
                    else
                        return 0;
               
            int hi = cantidadElemPar(pr.getHI());
            int hd = cantidadElemPar(pr.getHD());
            if(pr.getElem() %2 == 0)
                return hi + hd + 1;
            else
                return hi + hd;
            
        }
    public int cantidadElemPar(){
        return cantidadElemPar(raiz);
    }
    
    private int cantidadElemPrimos(Nodo pr){   
            if(pr == null){
                return 0;
            }
             else
                if (esHoja(pr))  // no es necesario
                    if(esPrimo(pr.getElem()))
                        return 1;
                    else
                        return 0;
               
            int hi = cantidadElemPrimos(pr.getHI());
            int hd = cantidadElemPrimos(pr.getHD());
            if(esPrimo(pr.getElem()))
                return hi + hd + 1;
            else
                return hi + hd;
            
        }
    public int cantidadElemPrimos(){
        return cantidadElemPrimos(raiz);
    }
    
    private void MostrarPares(Nodo pr, JTextArea jta){   
            if(pr == null){
                return;
            }
             else
                if (esHoja(pr))  // no es necesario
                    if(pr.getElem()%2 == 0)
                        jta.append(String.valueOf(pr.getElem() + " "));
                    else
                        return;
                else{ 
            MostrarPares(pr.getHI(),jta);
            MostrarPares(pr.getHD(),jta);
            if(pr.getElem() %2 == 0)
                jta.append(String.valueOf(pr.getElem() + " "));
        }}
    
    public void MostrarPares(JTextArea jta){
         MostrarPares(raiz,jta);
    }
    
    private void mostrarPrimos(Nodo pr, JTextArea jta){   
            if(pr == null){
                return;
            }
             else
                if (esHoja(pr))  // no es necesario
                    if(esPrimo(pr.getElem()))
                        jta.append(String.valueOf(pr.getElem() + " "));
                    else
                        return;
                else{ 
            mostrarPrimos(pr.getHI(),jta);
            mostrarPrimos(pr.getHD(),jta);
            if(esPrimo(pr.getElem()))
                jta.append(String.valueOf(pr.getElem() + " "));
        }
    }
    
    public void mostrarPrimos(JTextArea jta){
         mostrarPrimos(raiz,jta);
    }
    
     private int altura(Nodo pr){   
            if (pr == null) 
            return 0; 
        else 
        { 
            int hi = altura(pr.getHI()); 
            int hd = altura(pr.getHD()); 

            if (hi > hd) 
                return (hi + 1); 
             else 
                return (hd + 1); 
        }
     }
    public int altura(){
        return altura(raiz);
    }
    
    
   private boolean sonIguales (Nodo p1, Nodo p2){
        if (p1 == p2)  
            return true;   // si ambos son nulos o ambos son hoja con el mismo elemento retorna verdadero

        if ((p1 == null) || (p2 == null))  // si uno es nulo y el otro no retorna falso
            return false;
     
        boolean hi = sonIguales(p1.getHI(),p2.getHI());
        boolean hd = sonIguales(p1.getHD(),p2.getHD());
 
        if(hi == hd && p1.getElem() == p2.getElem())   // o simplemente retornar el resultado de esto
            return true;
        
        return false;
}
   public boolean sonIguales(Nodo p2)
   {
       return sonIguales(raiz,p2);
   }
   
   private boolean esLista(Nodo pr){
       Nodo auxI;
       Nodo auxD;
       if(pr == null)
           return true;
       else{
           auxI = raiz.getHI();
           auxD = raiz.getHD();
       }
       if(pr.getHI() != null && pr.getHD() != null)
           return false;
       while(auxI!=null){
           if(auxI.getHD() ==null)
               auxI = auxI.getHI();
           else
               return false;
       }
       while(auxD!=null){
           if(auxD.getHI() ==null)
               auxD = auxD.getHD();
           else
               return false;
       }
       return true;
   }
  public boolean esLista(){
      return esLista(raiz);
  }
 private int getAbuelo(Nodo pr, int x, int abuelo){
    if (pr == null) 
        return 0; 
  
    if(esHoja(pr))
        return 0;
    if(pr.getHD() !=null)
        if (pr.getHD().getElem() == x)  
        { 
            return abuelo;
        } 
    if(pr.getHI() !=null)
        if (pr.getHI().getElem() == x)  
        { 
            return abuelo;
        } 
    
    int hi = getAbuelo(pr.getHI(), x, pr.getElem()); 
    int hd = getAbuelo(pr.getHD(), x, pr.getElem()); 
    
    return hi + hd;
 }
  public int getAbuelo(int x){ 
      return getAbuelo(raiz,x,0);
  }
  
  private int mostrarAncestros(Nodo pr, int x,JTextArea jta){ 
        if (pr != null) {
            if(pr.getElem() == x){
                return 1;
            }
            if(mostrarAncestros(pr.getHI(),x,jta) == 1 || mostrarAncestros(pr.getHD(),x,jta) == 1){
                jta.append(String.valueOf(pr.getElem() + " "));
                return 1;
            }
    }
        return 0;
}
  
   public int mostrarAncestros(int x,JTextArea jta){
       return mostrarAncestros(raiz,x,jta);
   }
   
   public boolean esHijo(Nodo pr, int hijo){
       if(pr == null)
           return false;
       if(!esHoja(pr)){
           if(pr.getHD() != null && pr.getHD().getElem() == hijo)
               return true;
            if(pr.getHI() != null && pr.getHI().getElem() == hijo)
               return true;
       }
       return false;
   
   }
     private Nodo retornarHijos(Nodo p, int x)
        {
            if (p == null || esHoja(p))
                return null;
            
            if (x < p.getElem())
               p=retornarHijos(p.getHI(),x);
            else
              if (x > p.getElem())
                 p=retornarHijos(p.getHD(),x);
              else
                 return p;
            return p;
        }
        
        public Nodo retornarHijos(int x){
          return retornarHijos(raiz,x);
        }

    private void descendientes(Nodo pr, int x, boolean encontrado, JTextArea jta)
        {
            if(pr != null)
            {
                if(encontrado == true)
                {
                    jta.append(String.valueOf(pr.getElem() + " "));
                }
                if(pr.getElem() == x)
                {
                    encontrado = true;
                }
                descendientes(pr.getHI(),x,encontrado,jta);
                descendientes(pr.getHD(),x,encontrado,jta);
            }
        }
        public void descendientes(int x, JTextArea jta)
        {
                boolean encontrado = false;
                descendientes (raiz, x, encontrado,jta);
        }
        
        private void mostrarNietos(Nodo pr, int x, boolean encontrado, int nivel, JTextArea jta)
        {
            if (pr != null)  
            { 
                if(nivel == 2 && encontrado == true){
                    jta.append(String.valueOf(pr.getElem() + " "));
                }
                if (pr.getElem() == x){
                    encontrado = true;
                    nivel++;
                }else{
                    if(encontrado == true){
                        nivel++;
                    }
                } 
                mostrarNietos(pr.getHI(), x, encontrado, nivel, jta);
                mostrarNietos(pr.getHD(), x, encontrado, nivel, jta);
            }
        }

        public void mostrarNietos( int x,JTextArea jta)
        {
            int nivel = 0;
            boolean verificar = false;
            mostrarNietos(raiz, x, verificar, nivel,jta);
        }
        
    private void mostrarPorNivel(Nodo pr ,int nivel,JTextArea jta){ 
        if (pr == null) 
            return; 
        if (nivel == 1) 
            jta.append(pr.getElem() + " "); 
        else if (nivel > 1) { 
            mostrarPorNivel(pr.getHI(), nivel-1,jta); 
            mostrarPorNivel(pr.getHD(), nivel-1,jta); 
        } 
    } 
    public void mostrarPorNivel(JTextArea jta){ 
        for (int i = altura(raiz); i>=1; i--) {
            mostrarPorNivel(raiz, i,jta);
            jta.append("---- Nivel " + i);
            jta.append("\n");
        } 
    }
}        