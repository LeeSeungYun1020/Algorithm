string = input()
zeroCount = 0
oneCount = 0
for c in string:
  if c == "0":
    zeroCount += 1
  else:
    oneCount += 1

zeroCount /= 2
oneCount /= 2

checker = [True for _ in string]
for i in range(len(string)):
  c = string[i]
  if c == "1":
    oneCount -= 1
    checker[i] = False
  if oneCount <= 0:
    break

for i in range(len(string)).__reversed__():
  c = string[i]
  if c == "0":
    zeroCount -= 1
    checker[i] = False
  if zeroCount <= 0:
    break

answer = ""

for i in range(len(string)):
  if checker[i]:
    answer += string[i]

print(answer)
