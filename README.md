# java-testing-01

Controlled Maven fixture for CodeAnt SCA and the upgrade-impact agent: one module, six direct
dependencies with known advisories, real API usage per package, and same-named local decoys.
No lock file (Maven has none); the scanner resolves the tree with the depgraph plugin.

See `EXPECTED_RESULTS.md` (scan ground truth) and `EXPECTED_UPGRADE_VERDICTS.md` (agent ground truth).
