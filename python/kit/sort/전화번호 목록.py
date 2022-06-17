def solution(phone_book):
    phone_book.sort(key = lambda it: (it, len(it)) )
    for i in range(1, len(phone_book)):
        if phone_book[i].startswith(phone_book[i-1]):
            return False
    return True