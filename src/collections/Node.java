package collections;

public class Node<T> {
		protected  T info;
		protected Node<T> link; //self-referential variable
		
		public Node(T data) {
			info = data;
			link = null; //points to the next node	
		}

		public T getInfo() {
			return info;
		}

		public void setInfo(T info) {
			this.info = info;
		}

		public Node<T> getLink() {
			return link;
		}

		public void setLink(Node<T> link) {
			this.link = link;
		}
}

