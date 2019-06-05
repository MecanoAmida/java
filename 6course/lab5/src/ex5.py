from collections import Counter

xspam_data = {}


def file_parser():
    from_data = []
    with open('mbox.txt', 'r') as file:
        for line in file:
            counter = str.find(line, "From:")
            if counter == 0:
                buf = line.split(' ')
                buf = buf[1].split('\n')
                from_data.append(buf[0])
            k = str.find(line, "X-DSPAM-Confidence:")
            if k == 0 and xspam_data.get(buf[0]) is None:
                buf_xspam = line.split(' ')
                xspam_data[buf[0]] = (float(buf_xspam[1]))
            elif k == 0 and xspam_data.get(buf[0]) is not None:
                buf_xspam = line.split(' ')
                buffer = xspam_data.get(buf[0])
                xspam_data[buf[0]] = (float(buf_xspam[1])) + buffer
    return from_data, xspam_data


def create_new_massives(from_data):
    buf = Counter(from_data)
    dict_buf = dict(buf)
    list_buf = list(buf)
    return dict_buf, list_buf


def parse_massive(dict_buf, list_buf):
    key, value, xspam = [], [], []
    for element in list_buf:
        key.append(element)
        value.append(dict_buf[element])
        xspam.append(xspam_data[element] / dict_buf[element])
    return key, value, xspam


def main():
    from_data, xspam = file_parser()
    dict_buf, list_buf = create_new_massives(from_data)
    return parse_massive(dict_buf, list_buf)


if __name__ == "__main__":
    main()
