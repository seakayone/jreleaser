//usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA {{distributionJavaVersion}}
//REPOS jitpack
//DEPS {{jbangDistributionGA}}:{{repoBranch}}-SNAPSHOT

public class {{jbangAliasClassName}} {
    public static void main(String... args) throws Exception {
        {{distributionJavaMainClass}}.main(args);
    }
}