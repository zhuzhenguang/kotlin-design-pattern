rm -rf src 
ls -a
all=(*/)
for dir in "${all[@]}"; do
  echo "${dir}src/main/java"
  echo "${dir}src/test/java"
  rm -rf "${dir}src/main/java"
  rm -rf "${dir}src/test/java"
done

