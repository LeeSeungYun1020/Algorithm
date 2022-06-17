def solution(phone_book):
    map = {}
    for phone in phone_book:
        map[phone] = 1

    for phone in phone_book:
        num = ""
        for n in phone:
            num += n
            if num in map and num != phone:
                return False
    return True