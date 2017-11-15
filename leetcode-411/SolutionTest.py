from Solution import Solution


def testOnlineCase2():
    target = "apple"
    dictionary = {"plain", "amber", "blade"}
    expected = ["1p3",  "ap3", "a3e", "2p2", "3le", "3l1"]
    actual = Solution().minAbbreviation(target, dictionary)
    print actual

if __name__ == '__main__':
    testOnlineCase2()
