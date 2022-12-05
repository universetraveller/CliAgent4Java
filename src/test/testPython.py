import glob
import javalang
def interface(a, b, d, c):
    with open(d, 'r') as d:
        d = d.read()
    k = glob.glob(c)
    print(type(b))
    print(javalang.tokenizer.tokenize(a))
    return '{} {}'.format(d, k)
