# Java Gummy Bears

A small teaching example of a Spring Boot web api using Neo4j database.

## Requirements

- [Java SE Development Kit 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
- [Docker Desktop](https://www.docker.com/products/docker-desktop)

## Install

From the command-line (change the password in the `NEO4J_AUTH` environment variable):

``` shell
docker run \
    --name neo4j \
    -p7474:7474 -p7687:7687 \
    -d \
    -v neo4j_data:/data \
    -v neo4j_logs:/logs \
    -v neo4j_import:/var/lib/neo4j/import \
    -v neo4j_plugins:/plugins \
    --env NEO4J_AUTH=neo4j/secret \
    neo4j:latest
```

Open a browser to:
``` URL
http://localhost:7474/browser/
```

Connect to the database using user `neo4j` and password.

Enter this cyber script (at the command-line window at the top) for creating the data:

```  
create (Fruit:Package {name:"Fruity Duty", mass:50})
create (Pop:Package {name:"Snappy Pop", mass:200})
create (Mint:Package {name:"Cool Mint", mass:50})
create (Red:GummyBear {flavour:"Black Cherry", colour:"Red", name:"Cherry"})
create (Green:GummyBear {flavour:"Mint", colour:"Green", name:"Evergreen"})
create (Blue:GummyBear {flavour:"Blueberry", colour:"Blue", name:"Blueberry"})
create (Brown:GummyBear {flavour:"Cola", colour:"Brown", name:"Coke"})
create (Gold:GummyBear {flavour:"Ginger Ale", colour:"Gold", name:"Canada Dry"})
create 
	(Red)-[:PACKAGED_IN {contents:['Red']}]->(Fruit),
	(Blue)-[:PACKAGED_IN {contents:["Blue"]}]->(Fruit),
	(Green)-[:PACKAGED_IN {contents:["Green"]}]->(Mint),
	(Red)-[:PACKAGED_IN {contents:["Red"]}]->(Pop),
	(Brown)-[:PACKAGED_IN {contents:["Brown"]}]->(Pop),
	(Gold)-[:PACKAGED_IN {contents:["Gold"]}]->(Pop)
```

Remember to update your Neo4j password in `src/main/resources/application.properties`.

Run the code in your IDE of choice.

## Remove data

Delete all nodes and relationships:

```
MATCH (n) DETACH DELETE n
```