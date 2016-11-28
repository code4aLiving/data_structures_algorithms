
class MyDate:
    def __init__(self,day,month,year):
        self.day = day
        self.month = month
        self.year = year

    def __add__(self,other):
        month = (self.month + other.month)%12 
        result = MyDate(self.year + other.year,
                        (self.month + other.month)
