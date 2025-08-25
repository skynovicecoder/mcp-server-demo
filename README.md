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

# Configure Model Service
Then go to Settings > Model Service
select or add your preferred provider. Once you’ve made your choice, enter the API Base URL (refer to the chosen model’s API documentation) and your retrieved secret API token
In our case: add the name of the model you intend to use to the list of available models. For example, you can select Ollama to utilize a locally installed model.

# Configure MCP Tool Settings
Next, in the Settings > MCP Tools Settings
add our MCP server
We will give it a name and select the SSE event type.  //Type: Server Sent Events (SSE)
In the Server URL field, we will specify the address of our Spring Boot application 
and the corresponding SSE endpoint that we specified in the configuration earlier. // http://localhost:8080/sse
Click the Test Connection button to verify the accuracy of your connection

# Open a new chat
create a new chat and request a search for "find all alarms"