# Spring MCP Server Example

### 1. Build from Source

```bash
#Building the application from the root directory of the project

./maven clean build

#Building the Docker image

docker build --tag=spring-mcp-server:latest .

#Running in Docker

docker run -p 8080:8080 spring-mcp-server:latest

```

### 2. Download Ollama:
1. https://ollama.com/ //Download at local
2. ollama run llama3.2 //to download one model

### 3. SeekChat Application As Free Opensource MCP Client
# Clone the repository
git clone https://github.com/seekrays/seekchat.git
cd seekchat
# Install dependencies
npm install
# Run in development mode
npm run dev

# 4. Configure Model Service
Then go to Settings > Model Service
select or add your preferred provider. 

A. General Steps (PROD):

Once you’ve made your choice of the AI Model Provider:

a.1. Enter the API Base URL (refer to the chosen model’s API documentation) and 

a.2. your retrieved secret API token


B. Note (For Testing):
In our case: add the name of the model you intend to use to the list of available models. 
For example, you can select Ollama to utilize a locally installed model. 
(Installed above in step:2)

# Configure MCP Tool Settings
Next, in the Settings > MCP Tools Settings
Add our MCP server:

a. We will give it a name and select the SSE event type.  
//Type: Server Sent Events (SSE)  //Other option is STDIO(Standard IO) but for us SSE

b. In the Server URL field, we will specify the address of our Spring Boot application 
and the corresponding SSE endpoint that we specified in the configuration earlier. 
// http://localhost:8080/sse
Click the Test Connection button to verify the accuracy of your connection

# Open a new chat
create a new chat and request a search for "find all alarms"

### 5. H2 Database UI
Using H2’s built-in Web Server (Recommended for WebFlux)
Instead of registering the WebServlet, you can start the H2 console as its own HTTP server (independent of Tomcat/Netty/Jetty)
http://localhost:8082/  

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
Username/Pass : sa/

//In case of servlet i.e. starter-web, we can run on tomcat server itself using: http://localhost:8080/h2-console

h2:
console:
enabled: true
path: /h2-console