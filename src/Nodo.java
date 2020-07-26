
 class Nodo
 {
        private Nodo hijoIzq;
        private int elem;
        private Nodo hijoDer;

        public Nodo(int ele) {
            hijoIzq=null;
            elem = ele;
            hijoDer=null;
        }
        public void setHI(Nodo izq){
            hijoIzq = izq;
        }
        public void setElem(int e) {
            elem = e;
        }
        public void setHD(Nodo der) {
            hijoDer = der;
        }
        public Nodo getHI() {
            return hijoIzq;
        }
        public int getElem() {
            return elem;
        }
        public Nodo getHD() {
            return hijoDer;
        }
        public int getPadre(Nodo node, int val, int parent){
            if (node == null) 
                return 0; 
            if (node.getElem() == val)  
            { 
            return parent;
            } 
            int hi = getPadre(node.getHI(), val, node.getElem()); 
            int hd = getPadre(node.getHD(), val, node.getElem()); 
    
        return hi + hd;
    }

    }//end class