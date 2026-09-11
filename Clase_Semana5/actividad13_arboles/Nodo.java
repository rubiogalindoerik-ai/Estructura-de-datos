public class Nodo{
        int data;
        Nodo left;
        Nodo right;

        public Nodo(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static void preOrden(Nodo node) {
            if (node == null) return;
            System.out.println(node.data + " ");
            preOrden(node.left);
            preOrden(node.right);
        }

        public static void postOrden(Nodo node) {
            if (node == null) return;
            postOrden(node.left);
            postOrden(node.right);
            System.out.println(node.data + " ");
        }

        public static void inOrden(Nodo node) {
            if (node == null) return;
            inOrden(node.left);
            System.out.println(node.data + " ");
            inOrden(node.right);
        }
    }