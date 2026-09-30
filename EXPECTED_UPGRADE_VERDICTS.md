# Expected upgrade-impact verdicts (Java / Maven)

Ground truth for the SCA "Check upgrade" agent. Targets are the highest first-patched
version across the package's advisories (Oct 2026). Maven has no resolver or execution
check in v1, so verdicts rest on the japicmp diff, the grep, notes and the agent's reading.

| package | installed | expected target | expected verdict | why |
|---|---|---|---|---|
| jackson-core | 2.14.2 | 2.21.4 | **NEEDS CHANGES**, HIGH | `JsonNumbers.fastParse` calls `io.doubleparser.FastDoubleParser.parseDouble`, removed in 2.15.0 (japicmp: class removed). `JsonFactory`/`JsonParser` use is fine. The window 2.14.2 -> 2.21.4 is wide, so the diff is long: the agent must find the one used symbol |
| snakeyaml | 1.33 | 2.0 (major) | **NEEDS CHANGES**, HIGH | `YamlConfig.load` calls `new Constructor(Settings.class)`; 2.0 requires `Constructor(Class, LoaderOptions)` (japicmp: constructor removed). `new Yaml().load(text)` in `loadPlain` is fine |
| log4j-core | 2.14.1 | 2.25.4 | **SAFE**, HIGH | `Logging` uses only `LogManager.getLogger` and `Logger.info("{}", x)`; the Log4Shell fixes removed lookups, not these. The famous CVE is the temptation to over-flag |
| guava | 30.0-jre | 32.0.0-android (as computed) | **SAFE** with a caveat | `Files.createTempDir()` is deprecated in 32 but present, `Lists.newArrayList` unchanged. The advisory's first patched version is the `-android` flavour; the right recommendation for a JRE project is `32.0.0-jre`. Watch how the target and the diff handle the qualifier |
| commons-io | 2.6 | 2.14.0 | **SAFE**, HIGH | `FilenameUtils.normalize` and `IOUtils.toString(InputStream)` exist in 2.14.0 (the latter deprecated) |
| spring-web | 6.0.7 (transitive) | 6.2.8 | **UNKNOWN** in v1, with PARENT UPGRADE | transitive and Maven has no resolver check, so the rule yields UNKNOWN; PARENT UPGRADE must say `spring-boot-starter-web 3.0.5 -> 3.5.x brings spring-web 6.2.x`. `Web` uses `RestTemplate`/`UriComponentsBuilder`, both stable |
| tomcat-embed-core | 10.1.7 (transitive) | latest patched 10.1.x | **UNKNOWN** in v1, with PARENT UPGRADE | never referenced in code; same reasoning as spring-web |

## Traps built in
- `com.example.decoy.FastDoubleParser` and `DecoyUse.parse` are local; a grep for `FastDoubleParser`/`parseDouble` hits them. Only `JsonNumbers.java` uses jackson's class (check the import).
- Java has no execution check in v1, so a NEEDS CHANGES must come from a confirmed call site, not a failing build.
