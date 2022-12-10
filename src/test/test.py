import sys
# for RuntimeAgent
if __name__ == '__main__':
    if len(sys.argv) > 1:
        arg1 = sys.argv[1]
        arg2 = sys.argv[2]
    else:
        print('a@b')
        exit()
    print('{}@{}'.format(arg1, arg2))
# for PythonAgent
def getValue(arg1, arg2, arg3):
    print(arg3)
    return arg1*arg2
def returnValue():
    return 1
