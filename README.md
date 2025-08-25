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

### 2. SeekChat Application As Free Opensource MCP Client

# Clone the repository
git clone https://github.com/seekrays/seekchat.git
cd seekchat

# Install dependencies
npm install

# Run in development mode
npm run dev