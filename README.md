# 🎋 Intro:
This project is a Real-Time Chat Application that facilitates instant messaging between users. Leveraging modern technologies, this application ensures real-time communication with high reliability and scalability.

# 📦 Technologies:
• React      
• Java      
• Spring Boot    
• PostgreSQL       
• JUnit      
• Apache Kafka         
• WebSockets   
• Docker    
• AWS ECS    

# 👩🏽‍🍳 Features:
• User registration and authentication with secure JWT tokens    
• Real-time messaging between users through a WebSocket connection    
• Message queuing and delivery using Apache Kafka, ensuring no message is lost even if the recipient is offline   
• Persistent storage of user data in a PostgreSQL database   
• Currently - scalable architecture with Docker, integration of Kubernetes & AWS is in development    

# 💭 Process:
The development process began with designing the user management module, followed by the integration of real-time messaging capabilities using WebSockets. Apache Kafka was introduced to the architecture to manage message queues and ensure reliable message delivery. The application was containerized using Docker, making it scalable and cloud-ready with Kubernetes for orchestration. The project follows the Controller-Service-Repository pattern to maintain a clean separation of concerns and facilitate maintainability.

# 📚 Learnings:
This project provides deep insights into building scalable real-time applications. Key challenges include ensuring real-time performance with WebSockets, reliable message delivery with Kafka, and integrating these technologies within a Spring Boot application.   

# ✨ Improvements:
- Refining current functionality and implementing additional features such as group chats, message encryption, and user status indicators   
- Developing a user interface for a more engaging user experience    
- Expanding the application's scalability through the integration of Kubernetes and AWS services   

# 🚦 Running the Project:
1. Clone the repository   
2. Ensure Docker is set up on your machine    
3. Build the Docker images for the Spring Boot application, PostgreSQL, Kafka & Zookeeper from their respective Dockerfiles   
4. Access the application through `localhost` on the configured port, and use WebSocket clients to test real-time messaging   
