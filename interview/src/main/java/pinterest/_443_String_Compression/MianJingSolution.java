package pinterest._443_String_Compression;

/**
 * round 1: 改string compression的方法，比如说按照leetcode这个compression的方法，如果input是“abc”的话，output本来应该是“1a1b1c”，
 * 但是这样会占用6个Byte，想一个办法能够让这个output小于6Byte的长度，并且要能够正确地从output string decode回原来的encode string。
 * 还有一个条件是，input string里的每个char的出现次数为127以下。
 * 面试官给的正确方法是：对于input string为ab的情况，如果直接encode成output string为2ab，代表2后面有两个char只出现了一次，
 * 但是这样会产生歧义，decode时可能会是“ab”或者“aab”。所以这个附加条件就派上了用场。如果input string为“ab”的话，我们就把它encode成“(127+2)ab”，
 * 这样decode的时候就没有歧义了。。。
 */
public class MianJingSolution {
}
