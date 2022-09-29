package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.ColumnMapper;
import per.ja.pojo.Column;
import per.ja.pojo.Option;
import per.ja.pojo.PageBean;
import per.ja.service.ColumnsService;
import per.ja.util.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

public class ColumnsServiceImpl implements ColumnsService {
    //类型分页条件查询
    @Override
    public PageBean<Column> selectByPageAndCondition(int current_page, int page_size, Column column) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Column> columns = mapper.selectByPageAndCondition((current_page - 1) * page_size, page_size, column);
        Integer totalCnt = mapper.selectTotalCountByPageAndCondition(column);
        sqlsession.close();
        return new PageBean<>(totalCnt,columns);
    }

    @Override
    public boolean update(Column column) {
        if(column==null)return false;
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        sqlsession.getMapper(ColumnMapper.class).updateColumnTypeName(column);
        //提交事务
        sqlsession.commit();
        //释放资源
        sqlsession.close();
        return true;
    }

    //添加类型
    @Override
    public boolean add(Column parent, Column newChild) {
        if(parent!=null)
            newChild.setPTypeID(parent.getColumnID());
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        boolean flag = sqlsession.getMapper(ColumnMapper.class).addColumn(newChild);
        sqlsession.commit();
        sqlsession.close();
        return flag;
    }

    //删除类型
    public boolean delete(Column column){
        if(column==null)return false;
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Column> childes = mapper.selectChildType(column);
        //如果没有子类型，则允许删除
        //System.out.println(childes.size());
        if(childes.size()==0){
            boolean flag = mapper.deleteColumn(column);
            sqlsession.commit();
            sqlsession.close();
            return flag;
        }
        sqlsession.close();
        //否则不允许删除该类型
        return false;
    }

    @Override
    public List<Option> getCascade() {

        return _getCascade(new Column(null, null, null));
    }


    public List<Option> _getCascade(Column column){
        List<Option> options=new ArrayList<>();
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Column> columns = mapper.selectChildType(column);
        if(columns==null || columns.size()==0){
            //如果没有子节点先释放资源，再return null
            sqlsession.close();
            return null;
        }

        for(int i=0;i<columns.size();i++){
            Integer columnID = columns.get(i).getColumnID();
            String typeName = columns.get(i).getTypeName();
            options.add(new Option(Integer.toString(columnID),typeName, _getCascade(columns.get(i))));
        }

        sqlsession.close();
        return options;
    }

    @Override
    public List<Column> selectByIds(List<Integer> ids) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Column> columns = mapper.selectByIds(ids);
        List<Integer> leafNode = getLeafNode(columns);
        List<Column> leafNodeColumns = mapper.selectByIds(leafNode);

        sqlsession.close();

        return leafNodeColumns;
    }

    @Override
    public List<Integer> getTotancyIDs(List<Integer>ids) {
        List<Column> columns = selectByIds(ids);
        System.out.println(columns);
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Integer> integers = mapper.selectTotancyIDs(columns);
        sqlsession.close();
        return integers;
    }

    public List<Integer> getLeafNode(List<Column> cols){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        ColumnMapper mapper = sqlsession.getMapper(ColumnMapper.class);
        List<Integer>IDs=new ArrayList<>();
        List<Integer> _ids;
        for (Column c : cols) {
            Column column = mapper.slectById(c.getColumnID());
            if(column==null)continue;
            List<Column> children = mapper.selectChildType(column);
            if(children.size()!=0){
                _ids = getLeafNode(children);
                IDs.addAll(_ids);
            }else{
                IDs.add(column.getColumnID());
            }
        }
        sqlsession.close();
        return IDs;
    }

}
