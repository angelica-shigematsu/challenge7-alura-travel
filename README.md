# Jornada Milhas: API Travel

## Goal:
- Website of trip agency called Jornada Milhas
- Adapted Back-end challenge created by Alura

## Status:
- In Development

## Technologies:
- Java
- Spring Boot
- JPA Hibernate
- MySQL
- Open Ai Api
- Swagger (in future)
- Automated Test (in future)

## Technical Rules
  1) Budget and Destination table
     - Action: they went separate in another table
     - Why: because budget can change with time, it's necessary to book when change and keep others registration 
  2) Integration with Open AI Api
     - Action: Use Open AI to generate text description about specific country
     - Why: There are several places to describe, but the trip agency can describe by yoursef, too

## Routes - First version
- (GET) Show all destination created </br>
  - path: ``` localhost:8080/destinos/listar ``` </br></br>
  
- (Get): Show specific place </br>
  - path: ``` localhost:8080/destinos?nome=Madri ```</br></br>
  
- (Post): Create destionation </br>
  - path: ``` localhost:8080/destinos ``` </br></br>
  
- (Update): Alter data about destination </br>
  - path: ``` localhost:8080/destinos/:id ``` </br></br>
  
- (Delete): Disable destination </br>
  - path: ``` localhost:8080/destinos/:id ``` </br></br>

## Deploy from front
- GitHub link: <a href="https://angelica-shigematsu.github.io/challenge7-alura-travel-web/">Landing Page</a>
