# Expected SCA results — ground truth (Java / Maven)

| bucket | packages |
|---|---|
| Vulnerable, direct | `jackson-core@2.14.2`, `log4j-core@2.14.1`, `guava@30.0-jre`, `commons-io@2.6`, `snakeyaml@1.33` |
| Vulnerable, transitive (via spring-boot-starter-web 3.0.5) | `spring-web@6.0.7`, `tomcat-embed-core@10.1.7`, `jackson-databind@2.14.2` (if an advisory applies), `spring-core@6.0.7` (if an advisory applies) |
| Healthy | `spring-boot-starter-web@3.0.5` itself, `log4j-api@2.14.1`, `failureaccess`, `spring-boot-starter-json` and the rest of the Boot tree |

Scopes: everything is `compile` -> PROD. Relationship: the six declared artifacts are direct; the Boot tree is transitive.
